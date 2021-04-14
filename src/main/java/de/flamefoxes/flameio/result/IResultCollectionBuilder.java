package de.flamefoxes.flameio.result;

import com.google.gson.JsonObject;
import java.util.HashMap;

public interface IResultCollectionBuilder {

  public IResultCollectionBuilder addParsedElement(String json);

  public IResultCollectionBuilder addParsedElement(Object objects);

  public IResultCollectionBuilder addParsedElement(IResultPiece IResultPiece);

  public IResultPieceBuilder newPieceBuilder();

  public IResultPieceBuilder newPieceBuilderFromParsedObject(Object object);

  public IResultPieceBuilder newPieceBuilderFromParsedObjects(Object... object);

  public IResultCollectionBuilder newBuilder();

  public IResultCollection build();

  public IResultCollection buildFromJson(String json);


}
