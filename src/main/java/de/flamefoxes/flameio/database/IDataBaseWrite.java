package de.flamefoxes.flameio.database;

import de.flamefoxes.flameio.request.IManipulateRequest;
import de.flamefoxes.flameio.result.IResultCollectionBuilder;

public interface IDataBaseWrite {

  IResultCollectionBuilder createNewResultBuilder();

  IManipulateRequest createNewWriteRequest();

}
