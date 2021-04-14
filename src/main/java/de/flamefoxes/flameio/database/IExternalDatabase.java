package de.flamefoxes.flameio.database;

import de.flamefoxes.flameio.find.IOperator;

public interface IExternalDatabase {

  IOperator createNewFind();

  IDatabaseRead getCollectionRead(String collection);

}
