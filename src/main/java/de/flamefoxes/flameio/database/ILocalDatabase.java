package de.flamefoxes.flameio.database;


import de.flamefoxes.flameio.find.IOperator;
import de.flamefoxes.flameio.result.IResultCollectionBuilder;

public interface ILocalDatabase{

  IOperator createNewFind();

  IResultCollectionBuilder createNewCollectionBuilder();

  IDatabaseRead getCollectionRead(String collection);

  IDataBaseWrite getCollectionWrite(String collection);



}
