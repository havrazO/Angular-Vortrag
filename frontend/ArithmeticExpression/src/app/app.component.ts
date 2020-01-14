import { Component } from "@angular/core";
import { CalculateService } from "./calculate.service";
import { FormControl, Validators } from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";

interface Result {
  value: number;
  expression: string;
}

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  result: Result;

  expression: FormControl = new FormControl("", Validators.required);

  constructor(private calculateService: CalculateService) {}

  calculate(expression: string) {
    this.calculateService.calculateExpression(expression).subscribe(
      value => {
        this.result = {
          value: value,
          expression: this.expression.value
        };
      },
      (error: HttpErrorResponse) => {
        this.expression.setErrors({ error: error.error });
        this.result = null;
      }
    );
  }
}
