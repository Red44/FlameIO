package de.flamefoxes.flameio.result.feedback;

import de.flamefoxes.flameio.result.feedback.OperationResult;

public interface IOperationResult {

  boolean errored();

  OperationResult getOperationResult();

}
