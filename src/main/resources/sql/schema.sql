DROP TABLE PARKING_LOT IF EXISTS;;

CREATE TABLE IF NOT EXISTS PARKING_LOT (
    _id                     VARCHAR(60)  PRIMARY KEY,
    parking_area_id         VARCHAR      NOT NULL,
    child_parking_area_id     VARCHAR    NOT NULL
);

DROP TABLE PARKING_AREA IF EXISTS;

CREATE TABLE IF NOT EXISTS PARKING_AREA (
    _id                    VARCHAR(60)  PRIMARY KEY,
    location               VARCHAR      NOT NULL,
    owner                  VARCHAR      NOT NULL,
    child_parking_area_ids VARCHAR      NOT NULL
);

DROP TABLE VEHICLE IF EXISTS;

CREATE TABLE IF NOT EXISTS VEHICLE (
    _id                    VARCHAR(60)  PRIMARY KEY,
    owner                  VARCHAR      NOT NULL,
    color                  VARCHAR      NOT NULL
);

DROP TABLE DEMAND IF EXISTS;

CREATE TABLE IF NOT EXISTS DEMAND (
    _id                    VARCHAR(60)  PRIMARY KEY,
    type                   VARCHAR      NOT NULL,
    entity_id              VARCHAR      NOT NULL,
    entity_as_json         VARCHAR      NOT NULL
);

DROP TABLE DISPATCH IF EXISTS;

CREATE TABLE IF NOT EXISTS DISPATCH (
    _id                    VARCHAR(60)  PRIMARY KEY,
    supply_id              VARCHAR      NOT NULL,
    demand_id              VARCHAR      NOT NULL,
    start_timestamp        BIGINT       NOT NULL,
    end_timestamp          BIGINT
--     metadata_as_json       VARCHAR      NULLABLE
);

-- select * from DISPATCH where parking_area_id='pa1' AND end_timestamp=0