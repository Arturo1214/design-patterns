package bo.com.ahosfot.patterns.behavior.iterator.iterators;

import bo.com.ahosfot.patterns.behavior.iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();
}
