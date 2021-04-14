package de.flamefoxes.flameio.result;

import java.util.List;
import java.util.stream.Stream;

public interface IResultCollection {

  String getRawData();

  IResultPiece first();

  IResultPiece get(int number);

  List<IResultPiece> asList();

  IResultPiece[] asArray();

  Stream<IResultPiece> asStream();

  boolean empty();

  int size();

}
