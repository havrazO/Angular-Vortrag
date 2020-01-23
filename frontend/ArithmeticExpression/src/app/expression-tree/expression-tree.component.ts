import { Component, Input } from "@angular/core";
import { NestedTreeControl } from "@angular/cdk/tree";
import { MatTreeNestedDataSource } from "@angular/material/tree";

export interface Node {
  value: string;
  children?: Node[];
}

@Component({
  selector: "app-expression-tree",
  templateUrl: "./expression-tree.component.html",
  styleUrls: ["./expression-tree.component.css"]
})
export class ExpressionTreeComponent {
  treeControl = new NestedTreeControl<Node>(node => node.children);
  dataSource = new MatTreeNestedDataSource<Node>();

  @Input()
  set expression(expression) {
    this.dataSource.data = [this._transform(expression)];
  }

  constructor() {}

  hasChild = (_: number, node: any) =>
    !!node.children && node.children.length > 0;

  private _transform(expression) {
    if (expression.arg1) {
      let value;
      switch (expression.opAsString) {
        case "-":
        case "+":
          value = "Sum Expression";
          break;
        case "*":
        case "/":
          value = "Product Expression";
          break;
      }

      return {
        value: value,
        children: [
          this._transform(expression.arg2),
          { value: expression.opAsString } as Node,
          this._transform(expression.arg1)
        ]
      } as Node;
    }
    if (expression.value != NaN) {
      return { value: expression.value.toString() } as Node;
    }
    if (expression.bracketOpen) {
      return {
        value: "Bracket Expression",
        children: [
          { value: "(" } as Node,
          this._transform(expression.expression),
          { value: ")" } as Node
        ]
      } as Node;
    }
  }
}
