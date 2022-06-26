DROP TABLE IF EXISTS bank_account;

CREATE TABLE bank_account (
  iban VARCHAR(250) PRIMARY KEY,
  account_type VARCHAR(250) NOT NULL,
  interest DOUBLE NOT NULL,
  fees DOUBLE NOT NULL
);

INSERT INTO bank_account (iban, account_type, interest, fees) VALUES
  ('FR000000000001', 'Compte courant', 0.0, 0.02),
  ('FR000000000002', 'Compte courant', 0.0, 0.02),
  ('FR000000000003', 'Compte courant', 0.0, 0.02);