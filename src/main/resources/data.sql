INSERT INTO client(name, national_id, tenant_id) VALUES ('jon', '12345678Z', '1-tenant');
INSERT INTO client(name, national_id, tenant_id) VALUES ('pepito', '55555555A', '2-tenant');
INSERT INTO client(name, national_id, tenant_id) VALUES ('perico', '55555555B', '2-tenant');

INSERT INTO contract(reference, tenant_id,client_id, credit, version) VALUES ('ref-1','1-tenant', 1, 5000, 1);
INSERT INTO contract(reference, tenant_id, client_id, credit, version) VALUES ('ref-1','2-tenant', 2, 4000, 1);