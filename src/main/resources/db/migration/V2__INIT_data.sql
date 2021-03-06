--Fill tyre manufacturer information
INSERT INTO TYRE_MANUFACTURER VALUES (NEXTVAL('TYRE_MANUFACTURER_SEQ'), 'MRF', 'Madras Rubber Factory Limited');
INSERT INTO TYRE_MANUFACTURER VALUES (NEXTVAL('TYRE_MANUFACTURER_SEQ'), 'APOLLO TYRES', 'Apollo Tyres Ltd');
INSERT INTO TYRE_MANUFACTURER VALUES (NEXTVAL('TYRE_MANUFACTURER_SEQ'), 'CEAT', 'Ceat Tyres Ltd');
INSERT INTO TYRE_MANUFACTURER VALUES (NEXTVAL('TYRE_MANUFACTURER_SEQ'), 'JK Tyres', 'JK Tyres Ltd');
INSERT INTO TYRE_MANUFACTURER VALUES (NEXTVAL('TYRE_MANUFACTURER_SEQ'), 'Bridgestone', 'Bridgestone Tyres Ltd');
INSERT INTO TYRE_MANUFACTURER VALUES (NEXTVAL('TYRE_MANUFACTURER_SEQ'), 'Yokohama', 'Yokohama Tyres Ltd');

--Fill tyre brand information
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 1, 'MRF ZEC', 30000, 27000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 1, 'MRF SW99', 32000, 30000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 2, 'APOLLO AMAZER 3G', 32000, 30000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 3, 'CEAT MILAZE', 31000, 30000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 4, 'UX ROYALE', 30000, 27000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 5, 'ECOPIA EP850', 33000, 30000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 6, 'Avid Ascend', 34000, 31000);
INSERT INTO TYRE_BRAND VALUES (NEXTVAL('TYRE_BRAND_SEQ'), 6, 'Advan Sport', 33000, 32000);

--Fill bus provider information
INSERT INTO BUS_PROVIDER VALUES (NEXTVAL('BUS_PROVIDER_SEQ'), 'GREYHOUND', 'Best US Service Provider');
INSERT INTO BUS_PROVIDER VALUES (NEXTVAL('BUS_PROVIDER_SEQ'), 'SHIVNERI', 'Best MH Service Provider');
INSERT INTO BUS_PROVIDER VALUES (NEXTVAL('BUS_PROVIDER_SEQ'), 'NEETA', 'Bus Service Provider in India');
INSERT INTO BUS_PROVIDER VALUES (NEXTVAL('BUS_PROVIDER_SEQ'), 'MEGABUS', 'Bus Service Provider in the US');
INSERT INTO BUS_PROVIDER VALUES (NEXTVAL('BUS_PROVIDER_SEQ'), 'BOLTBUS', 'Bus Service Provider in the US');
INSERT INTO BUS_PROVIDER VALUES (NEXTVAL('BUS_PROVIDER_SEQ'), 'REDCOACH', 'Bus Service Provider in the US');

--Fill bus inventory information
INSERT INTO BUS_INVENTORY VALUES (NEXTVAL('BUS_INVENTORY_SEQ'), 1, 'GH-1001');
INSERT INTO BUS_INVENTORY VALUES (NEXTVAL('BUS_INVENTORY_SEQ'), 2, 'SH-1001');

--Fill tyre inventory information
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 1, 1, 0, 'N', 200, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 1, 1, 0, 'N', 200, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 1, 1, 0, 'N', 200, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 1, 1, 0, 'N', 200, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 2, 2, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 2, 2, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 3, 2, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 3, 2, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 2, null, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 2, null, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 3, null, 0, 'N', 300, now());
INSERT INTO TYRE_INVENTORY VALUES (NEXTVAL('TYRE_INVENTORY_SEQ'), 3, null, 0, 'N', 300, now());
