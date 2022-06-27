DROP TABLE IF EXISTS operation;

CREATE TABLE operation (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  amount DOUBLE NOT NULL,
  operation_type VARCHAR(250) NOT NULL,
  iban_source VARCHAR(250) NOT NULL,
  iban_target VARCHAR(250) NOT NULL
);

INSERT INTO operation (amount, operation_type, iban_source, iban_target) VALUES
  (100, 'Virement','FR182621829911','FR182621826628'),
  (500, 'Virement','FR182621829911','FR182621826633'),
  (500, 'Virement','FR182621829911','FR182621826689');