package bo.com.ahosfot.patterns.behavior.iterator.socialNetworks;

import bo.com.ahosfot.patterns.behavior.iterator.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);
    ProfileIterator createCoworkersIterator(String profileEmail);
}
