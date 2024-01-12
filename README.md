# String Similarity

A simple but extensible [redacted] app using string similarity; namely, Cosine Similarity with a TF-IDF input.

## Background
### Decision Matrix

Vector distance is more applicable in our case rather than edit distance.

| #                                             | Vector Similarity                                                                                       | Set Similarity                                               | Edit Distance            |
|-----------------------------------------------|---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------|--------------------------|
| Accuracy                                      | +1                                                                                                      | +1 <br> Also highly applicable in this (problem) case        | -1 <br> N/A in this case |
| Context Awareness (including order & overlap) | +1                                                                                                      | -1                                                           | -1                       |
| Extensibility                                 | +1 <br> Low effort integration with synonyms, context aware algorithms, and even ML techniques & models | -1                                                           | -1                       |
| Simplicity                                    | -1                                                                                                      | +1                                                           | +1                       |
| Document Length                               | +1                                                                                                      | +1 <br> Possible using variations like, the Dice Coefficient | 0                        |
| Speed                                         | -1                                                                                                      | +1                                                           | +1                       |
| Personal Experience                           | +1                                                                                                      | 0                                                            | 0                        |

## Solution

### Flow
```
Start
├─Get target documents
├─Pre-process
│  ├─Tokenize into words
│  └─Lower case
├─Get a weighted frequency of words in the vocabulary (tf-idf)
├─Calculate cosine similarity of each document with the others
└─Use a `max` 'activation' function to get the final probability.
```

### Edge Cases
- Assumes plain string; no intentional support for unicode.
- Optimized for the English grammar.

### Future Optimizations
- Use bigger n-gram values, instead of the current uni-gram.
- Some support for word order be achieved using bi-grams or tri-grams representation.
- Lemmatize the tokens to improve the true similarity score. (perhaps also word contractions)
- Test with other variants for TF-IDF. See: https://en.wikipedia.org/wiki/Tf%E2%80%93idf#Term_frequency
- [BM25](https://en.wikipedia.org/wiki/Okapi_BM25) can be used as a drop-in replacement to avoid saturation of high term frequency (by taking into account document length).

**Note**: To optimize for a highly targeted word alteration or the use of templates, word embeddings or algorithms like Latent Semantic Analysis can be used to also deduce the overall context of the document alongside existing string similarity.

### Opportunity
The saturation of large ML libraries in Java presents a possibility to release simple single purpose and well tested 'NLP' tools like: 
- Tokenization  
- Implementation of algorithms like Cosine Similarity and TF-IDF.

## User Manual
### Running the application
```
mvn compile exec:java
```

### Tests
```
mvn test
```

### Results
**Document Set 1:**

```
["Hello, world!", 
 "Hi, It's me. I'm him. This is my contact: me@google.com. Find me there please.",
 "This is a test contact. Please ignore."]

Similarity Probability: 
[0.0, 0.2206166238690754, 0.2206166238690754]
```

**Document Set 2:**

```
["You have been selected for a special offer. Click here to learn more.",
 "Hey, you're invited for a free vacation from the company.",
 "You have been selected for a special promotion. Click here to claim your reward."]

Similarity Probability: 
[0.53712750448132, 0.05885408024369296, 0.53712750448132]
```

**Document Set 3:**

```
["You have been pre-approved for a loan. Learn more in this link: totallyvalidloans.com",
 "You have been chosen for a limited time offer. Click here to claim your reward.",
 "Learn about our special opening in this link: totallyvalidloans.com"]

Similarity Probability:
[0.3280682353613186, 0.2342661658069919, 0.3280682353613186]
```


### References
- [Jaccard Coefficient Calculator](https://planetcalc.com/1664/)
- [Cosine Similarity Calculator](https://www.omnicalculator.com/math/cosine-similarity#the-cosine-similarity-formula)
- Literature search for 'Duplicate Message Detection Techniques (DMDT)'
- [Similarity Coefficients: A Beginner’s Guide to Measuring String Similarity](https://medium.com/@igniobydigitate/similarity-coefficients-a-beginners-guide-to-measuring-string-similarity-d84da77e8c5a)
- [A query suggestion method combining TF-IDF and Jaccard Coefficient for interactive web search](https://core.ac.uk/download/pdf/74375309.pdf)

## Disclaimer
Some data including boilerplate code was generated using GPT-3.
