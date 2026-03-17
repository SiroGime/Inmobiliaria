CREATE TABLE IF NOT EXISTS inmueble_fotos (
    id              BIGSERIAL PRIMARY KEY,
    tipo_inmueble   VARCHAR(30) NOT NULL,
    inmueble_id     INTEGER NOT NULL,
    image_url       VARCHAR(500) NOT NULL,
    public_id       VARCHAR(255) NOT NULL UNIQUE,
    orden           INTEGER NOT NULL DEFAULT 0,
    portada         BOOLEAN NOT NULL DEFAULT false,
    fecha_creacion  TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_fotos_tipo_inmueble_id
    ON inmueble_fotos(tipo_inmueble, inmueble_id);

CREATE INDEX IF NOT EXISTS idx_fotos_orden
    ON inmueble_fotos(tipo_inmueble, inmueble_id, orden, id);