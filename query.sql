--NON TESTATE!!!

--Stabilimenti aperti alla data corrente
SELECT S.nome, S.localita, S.via, S.civico,S.citta, S.telefono
FROM Stabilimento S
WHERE S.data_apertura<=? AND S.data_chiusura>=?;

--Inserimento utente
INSERT INTO Cliente(nome,cognome,residenza,documento_tipo,documento_ente,documento_numero,email,login,password) VALUES
	(?,?,?,?,?,?,?,?,?);
	
--Dati stabilimento singolo 
--Per i dati ristorante si usa l'attributo rendered
		
SELECT *
FROM Stabilimento S
WHERE S.nome=?;

SELECT COUNT(*) AS numeropostispiaggia
FROM Stabilimento S JOIN PostoSpiaggia PS ON PS.stabilimento=S.nome
WHERE S.nome=?
GROUP BY S.nome;

--prezzo per ogni fila per ogni periodo
SELECT PP.periodo_nome, PS.fila, PP.prezzo
FROM PostoSpiaggia PS JOIN PP ON PS.stabilimento=PP.posto_spiaggia_stabilimento AND PS.numero=PP.posto_spiaggia_numero
WHERE PS.stabilimento=?
GROUP BY PP.periodo_nome, PS.fila;

--check libero per prenotazione
SELECT 1
FROM NoleggioGiornaliero NG
WHERE NG.posto_spiaggia_stabilimento=? AND NG.posto_spiaggia_numero=? AND NG.data>=? AND NG.data<=?;

--altri liberi nello stesso periodo
--CI VA POSTOSPIAGGIA
SELECT NG.posto_spiaggia_stabilimento, NG.posto_spiaggia_numero
FROM NoleggioGiornaliero NG
WHERE NOT EXISTS(
					SELECT 1
					FROM NoleggioGiornaliero NG2
					WHERE NG2.data>=? AND NG2.data<=?
						AND NG2.posto_spiaggia_stabilimento=NG.posto_spiaggia_stabilimento AND NG2.posto_spiaggia_numero=NG.posto_spiaggia_numero
				);

--insert prenotazione
INSERT INTO Prenotazione(cliente,data_inizio,data_fine) VALUES
	(?,?,?);

--IDPRENOTAZIONE è l'id seriale aggiunto nella insert prenotazione: come si fa a prenderlo? secondo me se non si riesce a tirarlo giù da qualche metodo
--si fa una query grezza che tira giù il valore massimo dell'ID seriale in modo da sapere l'id dell'ultima prenotazione fatta
INSERT INTO NoleggioGiornaliero VALUES
	(?,?,?,?);
--	('data_inizio+1','numeroposto','stabilimento','IDPRENOTAZIONE'),
--	...
--	('data_fine','numeroposto','stabilimento','IDPRENOTAZIONE');