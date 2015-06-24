--TO DO:
--Decidere politiche on update, on delete (cascade...)
--Eventuale ritoccatina a qualche nome (da farli combaciare con l'ER)

CREATE TABLE Stabilimento (
	nome VARCHAR(30) PRIMARY KEY,
	localita VARCHAR(30) NOT NULL,
	via VARCHAR(30) NOT NULL,
	civico VARCHAR(5) NOT NULL,
	citta VARCHAR(30) NOT NULL,
	responsabile VARCHAR(30) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	data_apertura DATE NOT NULL,
	data_chiusura DATE NOT NULL,
	ha_salagiochi BOOLEAN NOT NULL,
	ha_volley BOOLEAN NOT NULL,
	ha_bocce BOOLEAN NOT NULL,
	ha_ristorante BOOLEAN NOT NULL
	h_apertura TIME,
	h_chiusura TIME,
	specialita TEXT,
	CHECK(CASE WHEN (ha_ristorante)
				THEN(h_apertura IS NOT NULL AND h_chiusura IS NOT NULL AND specialita IS NOT NULL)
				ELSE(h_apertura IS NULL AND h_chiusura IS NULL AND specialita IS NULL)
				END
				)
	);
	
CREATE TABLE RicavoMensile (
	anno INTEGER NOT NULL,
	mese INTEGER CHECK(mese>0 AND mese<13) NOT NULL,
	stabilimento VARCHAR(30) REFERENCES Stabilimento(nome)
								ON DELETE CASCADE
								ON UPDATE CASCADE,
	importo DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(anno,mese,stabilimento)
	);

CREATE TABLE PostoSpiaggia (
	numero INTEGER CHECK(numero>0) NOT NULL,
	stabilimento VARCHAR(30) REFERENCES Stabilimento(nome)
								ON DELETE CASCADE
								ON UPDATE CASCADE,
	fila INTEGER CHECK(fila>0) NOT NULL,
	numero_sdraio INTEGER CHECK(numero_sdraio>=0) NOT NULL,
	PRIMARY KEY(numero, stabilimento)
	);
	
CREATE TABLE Periodo (
	nome VARCHAR(30) PRIMARY KEY NOT NULL,
	data_inizio DATE NOT NULL,
	data_fine DATE NOT NULL CHECK(data_fine>data_inizio)
	);
	
CREATE TABLE PP (
	posto_spiaggia_stabilimento VARCHAR(30),
	posto_spiaggia_numero INTEGER,
	periodo_nome VARCHAR(30) REFERENCES Periodo(nome)
								ON DELETE CASCADE
								ON UPDATE CASCADE,,
	prezzo DECIMAL(6,2) NOT NULL,
	FOREIGN KEY(posto_spiaggia_stabilimento,posto_spiaggia_numero) REFERENCES PostoSpiaggia(stabilimento,numero),
	PRIMARY KEY(posto_spiaggia_stabilimento,posto_spiaggia_numero)
	);

CREATE TABLE Cliente (
	codice SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR(30) NOT NULL,
	cognome VARCHAR(30) NOT NULL,
	residenza VARCHAR(50) NOT NULL,
	documento_tipo VARCHAR(30) NOT NULL CHECK(documento_tipo IN ('cartaidentita','passaporto'),
	documento_ente VARCHAR(50) NOT NULL,
	documento_numero VARCHAR(30) NOT NULL,
	email VARCHAR(40) NOT NULL UNIQUE,
	login VARCHAR(30) NOT NULL UNIQUE,
	password VARCHAR(20) NOT NULL
	);

CREATE TABLE Prenotazione(
	id SERIAL PRIMARY KEY NOT NULL,
	cliente INTEGER REFERENCES Cliente(codice) NOT NULL
						ON DELETE CASCADE
						ON UPDATE CASCADE,,
	data_inizio DATE NOT NULL,
	data_fine DATE NOT NULL,
	importo DECIMAL(6,2),
	tipo_pagamento VARCHAR(20)
	);

CREATE TABLE NoleggioGiornaliero(
	data DATE NOT NULL,
	posto_spiaggia_numero INTEGER,
	posto_spiaggia_stabilimento VARCHAR(30),
	prenotazione INTEGER NOT NULL REFERENCES Prenotazione(id)
										ON DELETE CASCADE
										ON UPDATE CASCADE,,
	FOREIGN KEY(posto_spiaggia_stabilimento,posto_spiaggia_numero) REFERENCES PostoSpiaggia(stabilimento,numero)	
																		ON DELETE CASCADE
																		ON UPDATE CASCADE,
	PRIMARY KEY(data, posto_spiaggia_numero,posto_spiaggia_stabilimento)
	);