package de.flamefoxes.flameio.request;


import de.flamefoxes.flameio.result.IResultCollection;
import de.flamefoxes.flameio.result.IResultPiece;
import de.flamefoxes.flameio.result.feedback.FeedBack;
import de.flamefoxes.flameio.result.feedback.FeedBackResult;
import de.flamefoxes.flameio.sort.Sort;
import java.util.function.Consumer;

public interface IReadRequest {

  IReadRequest sortBy(Sort sort,String fieldName);

  IReadRequest size(int size);

  IReadRequest selectOnly(String name);

  IReadRequest selectOnly(String... name);

  FeedBackResult<IResultPiece> requestOne();

  FeedBackResult<IResultCollection> requestMany();

  FeedBackResult<Long> count();

  void count(FeedBack<Long> request);

  void requestOne(FeedBack<IResultPiece> request);

  void requestMany(FeedBack<IResultCollection> request);

}
