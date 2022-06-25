DROP TABLE IF EXISTS bank_account;

CREATE TABLE bank_account (
  iban VARCHAR(250) PRIMARY KEY,
  account_type VARCHAR(250) NOT NULL,
  interest DOUBLE NOT NULL,
  fees DOUBLE NOT NULL
);

INSERT INTO employees (iban, account_type, interest, fees) VALUES
  ('FR182621826628', 'Compte courant', 0.0, 0.02),
  ('FR182621826919', 'Compte courant', 0.0, 0.02),
  ('FR182621829911', 'Compte courant', 0.0, 0.02);