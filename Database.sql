CREATE TABLE USERS(firstName TEXT NOT NULL,
                    lastName TEXT NOT NULL,
                    email TEXT PRIMARY KEY,
                    password TEXT NOT NULL);
                    
CREATE TABLE RATINGS(rid INTEGER PRIMARY KEY AUTOINCREMENT,
                    fid TEXT,
                    email TEXT,
                    score INTEGER,
                    FOREIGN KEY(email) REFERENCES users(email));
