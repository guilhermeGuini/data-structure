package data.structure.flowevent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class PathFlow {

    public static class PathPublisher<T> extends SubmissionPublisher<T> {

        @Override
        public int submit(T item) {
            return super.submit(item);
        }
    }

    public static class PathSubscriber<T> implements Flow.Subscriber<T> {

        private Flow.Subscription subscription;
        private List<T> consumedItems = new ArrayList<>();

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1L);
        }

        @Override
        public void onNext(T item) {
            System.out.println("Received: " + item);
            consumedItems.add(item);
            subscription.request(1L);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println("Finish: onComplete");
        }
    }

}
