package bo.com.ahosfot.patterns.behavior.iterator.spammer;

import bo.com.ahosfot.patterns.behavior.iterator.iterators.ProfileIterator;
import bo.com.ahosfot.patterns.behavior.iterator.profile.Profile;
import bo.com.ahosfot.patterns.behavior.iterator.socialNetworks.SocialNetwork;

public class SocialSpammer {
    public SocialNetwork socialNetwork;
    public ProfileIterator profileIterator;

    public SocialSpammer(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("\nIterating over friends...\n");
        profileIterator = socialNetwork.createFriendsIterator(profileEmail);
        while (profileIterator.hasNext()) {
            Profile profile = profileIterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("\nIterating over coworkers...\n");
        profileIterator = socialNetwork.createCoworkersIterator(profileEmail);
        while (profileIterator.hasNext()) {
            Profile profile = profileIterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        System.out.println("Sent message to: '" + email + "'. Message body: '" + message + "'");
    }
}
