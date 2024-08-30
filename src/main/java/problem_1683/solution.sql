SELECT t.tweet_id FROM tweets t
WHERE
    length(t.content) > 15