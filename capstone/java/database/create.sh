#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=rental_property_db
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" && psql -U postgres -d $DATABASE -f "$BASEDIR/property.sql" &&

psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
