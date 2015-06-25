--NON TESTATE!!!

--Stabilimenti aperti alla data corrente
stab_aperti_oggi=}SELECT S.nome, S.localita, S.via, S.civico,S.citta, S.telefono
FROM Stabilimento S
WHERE S.data_apertura<=current_date AND S.data_chiusura>=current_date;

--Inserimento utente
new_utente=}INSERT INTO Cliente(nome,cognome,residenza,documento_tipo,documento_ente,documento_numero,email,login,password) VALUES
	(?,?,?,?,?,?,?,?,?);
	
--Dati stabilimento singolo 
--Per i dati ristorante si usa l'attributo rendered
		
dettaglio_stab=}SELECT *
FROM Stabilimento S
WHERE S.nome=?;

n_posti_stab=}SELECT COUNT(*) AS numeropostispiaggia
FROM Stabilimento S JOIN PostoSpiaggia PS ON PS.stabilimento=S.nome
WHERE S.nome=?
GROUP BY S.nome;

--prezzo per ogni fila per ogni periodo, assumiamo che i posti di ogni fila abbiano tutti lo stesso prezzo
prezzo_fila=}SELECT DISTINCT PP.periodo_nome, PS.fila, PP.prezzo
FROM PostoSpiaggia PS JOIN PP ON PS.stabilimento=PP.posto_spiaggia_stabilimento AND PS.numero=PP.posto_spiaggia_numero
WHERE PS.stabilimento=?
GROUP BY PP.periodo_nome, PS.fila, PP.prezzo;

--check libero per prenotazione
check_prenotabile=}SELECT 1
FROM NoleggioGiornaliero NG
WHERE NG.posto_spiaggia_stabilimento=? AND NG.posto_spiaggia_numero=? AND NG.data>=? AND NG.data<=?;

--altri liberi nello stesso periodo
--CI VA POSTOSPIAGGIA
posti_liberi_periodo=}SELECT NG.posto_spiaggia_stabilimento, NG.posto_spiaggia_numero
FROM NoleggioGiornaliero NG
WHERE NOT EXISTS(
					SELECT 1
					FROM NoleggioGiornaliero NG2
					WHERE NG2.data>=? AND NG2.data<=?
						AND NG2.posto_spiaggia_stabilimento=NG.posto_spiaggia_stabilimento AND NG2.posto_spiaggia_numero=NG.posto_spiaggia_numero
				);

--insert prenotazione
new_prenota=}INSERT INTO Prenotazione(cliente,data_inizio,data_fine) VALUES
	(?,?,?);

--IDPRENOTAZIONE � l'id seriale aggiunto nella insert prenotazione: come si fa a prenderlo? secondo me se non si riesce a tirarlo gi� da qualche metodo
--si fa una query grezza che tira gi� il valore massimo dell'ID seriale in modo da sapere l'id dell'ultima prenotazione fatta
new_prenota_singolo=}INSERT INTO NoleggioGiornaliero VALUES
	(?,?,?,?);
--	('data_inizio+1','numeroposto','stabilimento','IDPRENOTAZIONE'),
--	...
--	('data_fine','numeroposto','stabilimento','IDPRENOTAZIONE');