package de.flamefoxes.flameio.result.feedback;

public enum OperationResult {
  PACKET_LOSE(true),
  INVALID_RESPONSE(true),
  INVALID_FIND_SYNTAX(true) ,
  INVALID_INNER_FIND(true) ,
  INVALID_COLLECTION(true),
  INVALID_FIND_DATA_COMBINATION(true),
  MISSING_FIND(true),
  INVALID_TRANSMIT_DATA(true),
  INVALID_RESPONSE_DATA(true),
  INVALID_REQUEST_ACTION(true),
  SUCCESS(false),
  NO_CHANGE(false);

  private boolean errored;

  private  OperationResult(boolean errored){
    this.errored = errored;
  }

  public boolean isErrored() {
    return errored;
  }
}
