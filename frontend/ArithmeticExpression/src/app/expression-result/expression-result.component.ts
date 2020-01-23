import { Component, OnInit, Input } from "@angular/core";
import { CalculateEntity } from "src/model/calculateEntity";

@Component({
  selector: "app-expression-result",
  templateUrl: "./expression-result.component.html",
  styleUrls: ["./expression-result.component.css"]
})
export class ExpressionResultComponent implements OnInit {
  @Input() calculateEntity: CalculateEntity;

  constructor() {}

  ngOnInit() {}
}
