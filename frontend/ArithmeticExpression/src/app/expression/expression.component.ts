import { Component, OnInit } from "@angular/core";
import { CalculateEntity } from "src/model/calculateEntity";
import {
  FormControl,
  Validators,
  FormGroupDirective,
  NgForm
} from "@angular/forms";
import { CalculateService } from "../calculate.service";
import { tap, debounceTime } from "rxjs/operators";
import { HttpErrorResponse } from "@angular/common/http";
import { ErrorStateMatcher } from "@angular/material/core";

/** Error when invalid control is dirty or touched. */
export class CalculateStateMatcher implements ErrorStateMatcher {
  isErrorState(
    control: FormControl | null,
    _form: FormGroupDirective | NgForm | null
  ): boolean {
    return !!(control && control.invalid && (control.dirty || control.touched));
  }
}

@Component({
  selector: "app-expression",
  templateUrl: "./expression.component.html",
  styleUrls: ["./expression.component.css"]
})
export class ExpressionComponent implements OnInit {
  calculateEntity: CalculateEntity;
  expression: FormControl = new FormControl("");
  loading: boolean;
  matcher: CalculateStateMatcher = new CalculateStateMatcher();

  constructor(private calculateService: CalculateService) {}

  ngOnInit(): void {
    this.expression.valueChanges
      .pipe(
        tap(() => {
          this.calculateEntity = null;
          this.loading = true;
        }),
        // Throttle Requests
        debounceTime(1000)
      )
      .subscribe(input =>
        this.calculateService.calculateExpression(input).subscribe(
          // Fetch Request
          response => (this.calculateEntity = response),
          // On Error
          (err: HttpErrorResponse) => {
            this.loading = false;
            this.expression.setErrors({ error: err.error });
          },
          // After Request
          () => (this.loading = false)
        )
      );
  }
}
