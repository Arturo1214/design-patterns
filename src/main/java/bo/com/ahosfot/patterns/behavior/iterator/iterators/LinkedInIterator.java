package bo.com.ahosfot.patterns.behavior.iterator.iterators;

import bo.com.ahosfot.patterns.behavior.iterator.profile.Profile;
import bo.com.ahosfot.patterns.behavior.iterator.socialNetworks.LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class LinkedInIterator implements ProfileIterator {
    private LinkedIn linkedIn;
    private String type;
    private String email;
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> contacts = new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    @Override
    public boolean hasNext() {
        this.lazyLoad();
        return currentPosition < emails.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }
        String friendEmail = emails.get(currentPosition);
        Profile friendContact = contacts.get(currentPosition);
        if (friendContact == null) {
            friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
            contacts.set(currentPosition, friendContact);
        }
        currentPosition++;
        return friendContact;
    }

    @Override
    public void reset() {
        this.currentPosition = 0;
    }

    private void lazyLoad() {
        if (this.emails.size() == 0) {
            List<String> profiles = this.linkedIn.requestRelatedContactsFromLinkedInAPI(this.email, this.type);
            System.out.println("Profiles data " + (profiles != null ? profiles.toString() : "null"));
            for (String profile : profiles) {
                this.emails.add(profile);
                this.contacts.add(null);
            }
        }
    }

}
