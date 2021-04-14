package de.flamefoxes.flameio.request;

import de.flamefoxes.flameio.find.IFindOperator;
import de.flamefoxes.flameio.result.*;
import de.flamefoxes.flameio.result.feedback.IOperationResult;
import java.util.function.Consumer;

public interface IManipulateRequest {

  IResultCollectionBuilder newCollectionBuilder();

  IResultPieceBuilder newPieceBuilder();

  IResultPieceBuilder newPieceBuilderFromParsedObject(Object object);

  IResultPieceBuilder newPieceBuilderFromParsedObjects(Object... object);

  IManipulateRequest locate(IFindOperator find);

  IManipulateRequest dataSet(IResultCollection IResultSet);

  IManipulateRequest oneDatSet(IResultPiece resultPiece);

  void insertOne(Consumer<IOperationResult> operationResult);

  void insertMany(Consumer<IOperationResult> operationResult);

  void updateMany(Consumer<IOperationResult> operationResult);

  void updateOne(Consumer<IOperationResult> operationResult);

  void deleteOne(Consumer<IOperationResult> operationResult);

  void deleteMany(Consumer<IOperationResult> operationResult);

  void replaceOne(Consumer<IOperationResult> operationResult);


  IOperationResult insertOne();

  IOperationResult insertMany();

  IOperationResult updateMany();

  IOperationResult updateOne();

  IOperationResult deleteOne();

  IOperationResult deleteMany();

  IOperationResult replaceOne();


}
