import { Component } from "@angular/core";
import { CalculateService } from "./calculate.service";
import {
  FormControl,
  Validators,
  FormGroupDirective,
  NgForm
} from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";
import { CalculateEntity } from "src/model/calculateEntity";
import { Observable, empty } from "rxjs";
import { catchError, debounceTime, tap } from "rxjs/operators";
import { ErrorStateMatcher } from "@angular/material/core";

/** Error when invalid control is dirty or touched. */
export class CalculateStateMatcher implements ErrorStateMatcher {
  isErrorState(
    control: FormControl | null,
    form: FormGroupDirective | NgForm | null
  ): boolean {
    return !!(control && control.invalid && (control.dirty || control.touched));
  }
}

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  calculateEntity$: Observable<CalculateEntity>;
  expression: FormControl = new FormControl("", Validators.required);
  loading: boolean;
  matcher: CalculateStateMatcher = new CalculateStateMatcher();

  constructor(private calculateService: CalculateService) {
    this.expression.valueChanges
      .pipe(
        tap(() => {
          this.calculateEntity$ = null;
          this.loading = true;
        }),
        debounceTime(500)
      )
      .subscribe(input => {
        this.loading = false;
        this.calculateEntity$ = this.calculateService
          .calculateExpression(input)
          .pipe(
            catchError((err: HttpErrorResponse) => {
              this.expression.setErrors({ error: err.error });
              return empty();
            })
          );
      });
  }
}
