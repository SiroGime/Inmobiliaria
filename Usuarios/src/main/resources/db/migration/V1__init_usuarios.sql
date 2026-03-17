CREATE TABLE IF NOT EXISTS usuario (
    id              SERIAL PRIMARY KEY,
    nombre          VARCHAR(50) NOT NULL,
    email           VARCHAR(255) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    rol             VARCHAR(20) NOT NULL DEFAULT 'AGENTE',
    CONSTRAINT chk_usuario_rol CHECK (rol IN ('ADMIN', 'AGENTE'))
);

CREATE INDEX IF NOT EXISTS idx_usuario_email ON usuario(email);