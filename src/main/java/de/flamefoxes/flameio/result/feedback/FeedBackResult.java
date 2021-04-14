package de.flamefoxes.flameio.result.feedback;

import de.flamefoxes.flameio.result.feedback.IOperationResult;

public interface FeedBackResult<T> {

  IOperationResult getOperationResult();

  T getResult();

}
