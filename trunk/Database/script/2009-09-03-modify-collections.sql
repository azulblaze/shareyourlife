drop index C_UNIQUE on collections;
go
create unique index C_UNIQUE  on collections (account ASC,name ASC);
go