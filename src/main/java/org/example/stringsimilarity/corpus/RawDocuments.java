package org.example.stringsimilarity.corpus;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RawDocuments {

    private RawDocuments(){}

    public final static Set<String> sample1 = new LinkedHashSet<>(List.of(
            "Hello, world!",
            "Hi, It's me. I'm him. This is my contact: me@google.com. Find me there please.",
            "This is a test contact. Please ignore."
            ));

    public final static Set<String> sample2 = new LinkedHashSet<>(List.of(
        "You have been selected for a special offer. Click here to learn more.",
        "Hey, you're invited for a free vacation from the company.",
        "You have been selected for a special promotion. Click here to claim your reward."
    ));

    public final static Set<String> sample3 = new LinkedHashSet<>(List.of(
            "You have been pre-approved for a loan. Learn more in this link: totallyvalidloans.com",
            "You have been chosen for a limited time offer. Click here to claim your reward.",
            "Learn about our special opening in this link: totallyvalidloans.com"
    ));
}
