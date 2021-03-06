import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, empty } from "rxjs";
import { CalculateEntity } from "src/model/calculateEntity";

@Injectable({
  providedIn: "root"
})
export class CalculateService {
  private ressource: string =
    "http://localhost:8080/ArithmetricExpressions/calculate";

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "text/plain"
    })
  };

  constructor(private httpClient: HttpClient) {}

  public calculateExpression(expression: string): Observable<CalculateEntity> {
    return expression
      ? this.httpClient.post<CalculateEntity>(
          this.ressource,
          expression,
          this.httpOptions
        )
      : empty();
  }
}
