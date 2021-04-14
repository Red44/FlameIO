package de.flamefoxes.flameio.result;

import java.util.HashMap;

public interface IResultPieceBuilder {

  public IResultPieceBuilder set(Object object);

  public IResultPieceBuilder set(String json);

  public IResultPieceBuilder add(String name,IResultPiece resultPiece);

  public IResultPieceBuilder add(String name, IResultPieceBuilder resultPieceBuilder);

  public IResultPieceBuilder add(String name,String json);

  public IResultPieceBuilder add(String name,Object object);

  public IResultPieceBuilder add(String name,Object... object);

  public IResultPieceBuilder add(String name,HashMap<String,Object> fields);

  public IResultPieceBuilder addToArray(Object object);

  public IResultPieceBuilder addToArray(String name,Object object);

  public IResultPieceBuilder addProperty(String name,Object object);

  public IResultPieceBuilder addProperty(String name,Object... object);

  public IResultPieceBuilder addProperty(String name,HashMap<String,Object> fields);

  public IResultPieceBuilder addNamelessPropertyToArray(Object object);

  public IResultPieceBuilder addPropertyToArray(String name,Object object);

  public IResultPieceBuilder navigate(String name);

  public IResultPieceBuilder navigateArray(String name,int index);

  public IResultPieceBuilder navigateFromArrayToArray(int currentArrayIndex);

  public IResultPieceBuilder navigateFromArrayToObject(int arrayIndex);

  public IResultPieceBuilder navigateBack();

  public IResultPieceBuilder resetNavigation();

  public IResultPiece build();

  public IResultPieceBuilder newObjectBuilder();

  public IResultPieceBuilder newArrayBuilder();

}
