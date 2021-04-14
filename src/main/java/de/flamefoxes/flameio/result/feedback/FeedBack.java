package de.flamefoxes.flameio.result.feedback;

import de.flamefoxes.flameio.result.feedback.IOperationResult;

public interface FeedBack<T> {

  public void feedback(IOperationResult operationResult,T t);

}
