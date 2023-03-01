db = db.getSiblingDB('mfcdb');

db.createCollection('decks');

db.decks.insertMany(
    [
        {
            name: "german 101",
            type: "phrases",
            tags: [],
            flashcards: [
                {
                    "back": "I'm not sure",
                    "front": "Ich bin mir nicht Sicher"
                },
                {
                    "back": "are you available tomorrow?",
                    "front": "Sind Sie morgen verfügbar?"
                },
                {
                    "back": "What did you do yesterday?",
                    "front": "Was hast du gestern gemacht?"
                },
                {
                    "back": "What are you doing there?",
                    "front": "was machst Du da?"
                },
                {
                    "back": "let's go to the cantine",
                    "front": "Lass uns die Cantine gehen"
                },
                {
                    "back": "that's not right",
                    "front": "Das ist nicht richtig"
                },
                {
                    "back": "What do you like to do?",
                    "front": "Was möchten Sie tun?"
                },
                {
                    "back": "I can't see it",
                    "front": "Ich sehe es nicht"
                },
                {
                    "back": "My friend is with Gianni",
                    "front": "Die Mutter is bei dem Gianni"
                },
                {
                    "back": "Have a nice day",
                    "front": "Eine schöner Tag noch"
                },
                {
                    "back": "I feel really good today",
                    "front": "Mir geht ist Heute sehr gut"
                },
                {
                    "back": "I have to go",
                    "front": "Ich muss gehen"
                },
                {
                    "back": "Why are you late?",
                    "front": "Warum bist du zu spät?"
                },
                {
                    "back": "Sorry for being late",
                    "front": "Es tut mir leid daß ist zu spät bin"
                },
                {
                    "back": "I have to go to the gym",
                    "front": "Ich muss ins Fitnessstudio"
                },
                {
                    "back": "Can we meet next week?",
                    "front": "Können wir uns nächste Woche treffen?"
                },
                {
                    "back": "How was your Journey?",
                    "front": "Wie war Ihre Reise?"
                },
                {
                    "back": "Have fun",
                    "front": "Viel Späß"
                },
                {
                    "back": "just a minute, please",
                    "front": "Nur eine Minute bitte"
                },
                {
                    "back": "are you ready",
                    "front": "Bist du bereit?"
                },
                {
                    "back": "I have no idea",
                    "front": "Keine Ahnung!"
                },
                {
                    "back": "Where do you live?",
                    "front": "Wo lebst du?"
                },
                {
                    "back": "Do you work as Veterinarian?",
                    "front": "Arbeitest du nicht als Ärztin?"
                },
                {
                    "back": "I'm planning to stay at home",
                    "front": "Ich habe vor, zu Hause zu bleiben"
                },
                {
                    "back": "I'm free tomorrow",
                    "front": "Ich bin morgen frei"
                },
                {
                    "back": "I need more time off",
                    "front": "Ich brauche mehr Urlaub"
                },
                {
                    "back": "wahrscheinlich hast du recht",
                    "front": "You are probably right"
                },
                {
                    "back": "It doesn't matter",
                    "front": "das ist egal"
                },
                {
                    "back": "Keine Eile",
                    "front": "No rush (no hay apuro)"
                }
            ]
        }
    ]
);