create table public.xls_data (
    id SERIAL,
    brand varchar(100) NOT NULL,
    model varchar(100) NOT NULL,
    width INTEGER NOT NULL,
    height INTEGER NOT NULL,
    diameter INTEGER NOT NULL,
    season varchar(100) NULL,
    country varchar(100) NULL,
    balance INTEGER NOT NULL,
    gross_price DECIMAL(12,2) NOT NULL,
    year_made INTEGER NULL
);