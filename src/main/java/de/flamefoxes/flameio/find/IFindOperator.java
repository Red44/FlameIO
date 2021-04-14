package de.flamefoxes.flameio.find;

public interface IFindOperator extends IFind, IOperator {

  IFindBuilder asNewTemplate();

  IFindOperator copy();
}
