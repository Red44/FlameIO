package de.flamefoxes.flameio.database;

import de.flamefoxes.flameio.find.IFind;
import de.flamefoxes.flameio.find.IFindOperator;
import de.flamefoxes.flameio.request.IReadRequest;

public interface IDatabaseRead {

  IReadRequest createNewReadRequest(IFindOperator find);

}