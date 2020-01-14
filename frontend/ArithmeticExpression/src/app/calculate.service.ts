import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class CalculateService {
  private ressource: string =
    "http://localhost:8080/ArithmeticExpression/calculate";

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "text/plain"
    })
  };

  constructor(private httpClient: HttpClient) {}

  public calculateExpression(expression: string): Observable<number> {
    return this.httpClient.post<number>(
      this.ressource,
      expression,
      this.httpOptions
    );
  }
}
