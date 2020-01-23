import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpressionTreeComponent } from './expression-tree.component';

describe('ExpressionTreeComponent', () => {
  let component: ExpressionTreeComponent;
  let fixture: ComponentFixture<ExpressionTreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpressionTreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpressionTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
