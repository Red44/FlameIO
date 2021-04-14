package de.flamefoxes.flameio.result;

public interface IResultPiece {

  <T> T getValue(Class<T> clazz);// if no default parser found gson will pars it as an  object

  <T> T getValue(String name,Class<T> clazz);// if no default parser found it will

  <T> T getValue(DefaultClass defaultClass); // enum shortcut :D

  <T> T getValue(String name,DefaultClass defaultClass);// enum shortcut :D


  <T> T getValueAsObject(Class<T> clazz);//  gson will pars it as an  object

  <T> T getValueAsObject(String name,Class<T> clazz);// gson will pars it as an object


  String getValuePrimitive(); // returns json if the object is incomplete ex : accessing a array as a single value

  String getValuePrimitive(String name); // returns json if the object is incomplete ex : accessing a array as a single value

  IResultPiece get(String name);

  IResultPiece pointAsAnArray(int index); // return this if there is no array

  IResultPiece pointAsAnArray(int index,String name); // return this if there is no array

  IResultPiece clone();


}
