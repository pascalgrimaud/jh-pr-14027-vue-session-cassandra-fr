
CREATE TABLE IF NOT EXISTS cassBankAccount (
    id uuid,
    userId uuid,
    name text,
    bankNumber int,
    agencyNumber bigint,
    lastOperationDuration float,
    meanOperationDuration double,
    balance decimal,
    lastOperationDate timestamp,
    active boolean,
    picture blob,
    picture_content_type text,
    operationsFile blob,
    operations_file_content_type text,
    accountType text,
    PRIMARY KEY(id)
);
