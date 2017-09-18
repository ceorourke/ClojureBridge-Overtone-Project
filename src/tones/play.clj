(ns tones.play
  (:use ;[clojure.repl]
        [tones.twinkle]
        [overtone.live]
        [overtone.inst.piano]))

(twinkle)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; evaluate whole file by hitting
;;   ctrl + shift + enter, or
;;   cmd + shift + enter
;;
;; add some functions under these comment lines
;; evaluate each form (line or function) by hitting
;;   ctrl + enter, or
;;   cmd + enter
;;(demo (pan2 (sin-osc 220)))
;; for example
;; (piano 67)
;;
;; listen to the sound you have made
;;
(defn piano-chord
  [root chord-name]
  (doseq [note (chord root chord-name)]
    (piano note)))

(defn up-above
  [start]
  (let [step 650
        notes [:g3 :g3 :f3 :f3 :e3 :e3 :d3]]
    (dotimes [i (count notes)]
      (at (+ start (* i step)) (piano (note (nth notes i)))))))

(let [start (now)]
  (twinkle start)
  (up-above (+ start 10400))
  (up-above (+ start 15600))
  (twinkle (+ start 20800)))

