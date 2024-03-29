-- -- ----------------------------
-- Table unimdb.feed
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.feed
(
    id         INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    user_id    INT NOT NULL,
    caption    TEXT,
    shared_feed_id INT,
    user_tagged_id INT,
    shared_count INT DEFAULT 0,
    latitude   FLOAT,
    longitude  FLOAT,
    image_path VARCHAR(255),
    image_size FLOAT,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES unimdb.users (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (user_tagged_id)
        REFERENCES unimdb.users (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (shared_feed_id)
        REFERENCES unimdb.feed (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE INDEX fk_user_feed1_idx on unimdb.feed (user_id);


-- -- ----------------------------
-- Table unimdb.comments
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.comments
(
    id   INT  NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    text TEXT NOT NULL,
    tagged_user_id INT,
    parent_comment_id INT,
    created_at TIMESTAMP default current_timestamp,
    user_id INT NOT NULL,
    like_count INT DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES unimdb.users (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (tagged_user_id)
        REFERENCES unimdb.users (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (parent_comment_id)
        REFERENCES unimdb.comments (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);


-- -- ----------------------------
-- Table unimdb.hashtags
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.hashtags
(
    id   INT         NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    text VARCHAR(64) NOT NULL
);

-- -- ----------------------------
-- Table unimdb.likes
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.like_types
(
    id    INT         NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    label VARCHAR(50) NOT NULL
);

-- -- ----------------------------
-- Table unimdb.likes
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.likes
(
    user_id    INT NOT NULL,
    feed_id    INT NOT NULL,
    type_id    INT NOT NULL,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    FOREIGN KEY (user_id)
        REFERENCES unimdb.users (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (feed_id)
        REFERENCES unimdb.feed (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (type_id)
        REFERENCES unimdb.like_types (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE INDEX fk_likes_user1_idx on unimdb.likes (user_id);
CREATE INDEX fk_likes_feed1_idx on unimdb.likes (feed_id);
CREATE INDEX fk_likes_type1_idx on unimdb.likes (type_id);


-- -- ----------------------------
-- Table unimdb.comments_feed_map
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.comments_feed_map
(
    feed_id    INT NOT NULL,
    comment_id INT NOT NULL,
    FOREIGN KEY (feed_id)
        REFERENCES unimdb.feed (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (comment_id)
        REFERENCES unimdb.comments (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE INDEX fk_map_comment_feed1_idx on unimdb.comments_feed_map (feed_id);
CREATE INDEX fk_map_comment_comment1_idx on unimdb.comments_feed_map (comment_id);


-- -- ----------------------------
-- Table unimdb.comments_feed_map
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.feed_hashtag_map
(
    feed_id    INT NOT NULL,
    hashtag_id INT NOT NULL,
    FOREIGN KEY (feed_id)
        REFERENCES unimdb.feed (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (hashtag_id)
        REFERENCES unimdb.hashtags (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE INDEX fk_map_hashtag_hashtag1_idx on unimdb.feed_hashtag_map (hashtag_id);
CREATE INDEX fk_map_hashtag_feed1_idx on unimdb.feed_hashtag_map (feed_id);
