CREATE TABLE USERS(uid INTEGER PRIMARY KEY AUTOINCREMENT,
                    firstName TEXT NOT NULL,
                    lastName TEXT NOT NULL,
                    email TEXT PRIMARY KEY,
                    password TEXT NOT NULL);
                    
CREAT TABLE RATINGS(rid INTEGER PRIMARY KEY AUTOINCREMENT,
                    fid TEXT,
                    uid TEXT,
                    score INTEGER,
                    FOREIGN KEY(uid) REFERENCES users(uid));
