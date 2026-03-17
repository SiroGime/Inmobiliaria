CREATE TABLE IF NOT EXISTS casa (
    id                  SERIAL PRIMARY KEY,
    direccion           VARCHAR(255),
    precio              DOUBLE PRECISION,
    disponible          BOOLEAN NOT NULL DEFAULT true,
    fecha_publicacion   DATE,
    operacion           VARCHAR(20),
    dormitorios         INTEGER,
    banios              INTEGER,
    garage              INTEGER,
    area                BIGINT,
    tamanio_lote        BIGINT
);

CREATE TABLE IF NOT EXISTS departamento (
    id                  SERIAL PRIMARY KEY,
    direccion           VARCHAR(255),
    precio              DOUBLE PRECISION,
    disponible          BOOLEAN NOT NULL DEFAULT true,
    fecha_publicacion   DATE,
    operacion           VARCHAR(20),
    dormitorios         INTEGER,
    banios              INTEGER,
    garage              INTEGER,
    piso                INTEGER,
    expensas            DOUBLE PRECISION,
    area                BIGINT,
    tamanio_lote        BIGINT
);

-- "locales" para evitar conflicto con LOCAL
CREATE TABLE IF NOT EXISTS locales (
    id                  SERIAL PRIMARY KEY,
    direccion           VARCHAR(255),
    precio              DOUBLE PRECISION,
    disponible          BOOLEAN NOT NULL DEFAULT true,
    fecha_publicacion   DATE,
    operacion           VARCHAR(20),
    banios              INTEGER,
    garage              INTEGER,
    area                BIGINT,
    tamanio_lote        BIGINT,
    tiene_deposito      BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS ph (
    id                  SERIAL PRIMARY KEY,
    direccion           VARCHAR(255),
    precio              DOUBLE PRECISION,
    disponible          BOOLEAN NOT NULL DEFAULT true,
    fecha_publicacion   DATE,
    operacion           VARCHAR(20),
    dormitorios         INTEGER,
    banios              INTEGER,
    garage              INTEGER,
    area                BIGINT,
    tamanio_lote        BIGINT
);

CREATE TABLE IF NOT EXISTS terreno (
    id                  SERIAL PRIMARY KEY,
    direccion           VARCHAR(255),
    precio              DOUBLE PRECISION,
    disponible          BOOLEAN NOT NULL DEFAULT true,
    fecha_publicacion   DATE,
    operacion           VARCHAR(20),
    tamanio_lote        BIGINT
);

CREATE TABLE IF NOT EXISTS leads (
    id                  SERIAL PRIMARY KEY,
    inmueble_id         INTEGER,
    nombre              VARCHAR(255) NOT NULL,
    email               VARCHAR(255) NOT NULL,
    telefono            VARCHAR(100),
    mensaje             VARCHAR(1000),
    estado              VARCHAR(30) NOT NULL DEFAULT 'NUEVO',
    fecha_creacion      TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_leads_fecha_creacion ON leads(fecha_creacion DESC);
CREATE INDEX IF NOT EXISTS idx_leads_inmueble_id ON leads(inmueble_id);

CREATE INDEX IF NOT EXISTS idx_casa_operacion ON casa(operacion);
CREATE INDEX IF NOT EXISTS idx_departamento_operacion ON departamento(operacion);
CREATE INDEX IF NOT EXISTS idx_locales_operacion ON locales(operacion);
CREATE INDEX IF NOT EXISTS idx_ph_operacion ON ph(operacion);
CREATE INDEX IF NOT EXISTS idx_terreno_operacion ON terreno(operacion);