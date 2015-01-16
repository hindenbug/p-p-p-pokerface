(ns p-p-p-pokerface)

(def replacements {\T 10, \J 11, \Q 12,
                   \K 13, \A 14})

(defn rank [card]
  (let [[f _] card]
    (if (Character/isDigit f)
      (Integer/valueOf (str f))
      (replacements f))))

(defn suit [card]
  (let [[_ s] card]
    (str s)))

(defn pair? [hand]
  (<= 2 (apply max (vals (frequencies (map rank hand))))))

(defn three-of-a-kind? [hand]
  (<= 3 (apply max (vals (frequencies (map rank hand))))))

(defn four-of-a-kind? [hand]
  (<= 4 (apply max (vals (frequencies (map rank hand))))))

(defn flush? [hand]
  (= 5 (apply max (vals (frequencies (map suit hand))))))

(defn full-house? [hand]
  (= [2 3] (sort (vals (frequencies (map rank hand))))))

(defn two-pairs? [hand]
  (or (= [1 2 3] (sort (vals (frequencies (map rank hand)))))
      (= [1 4] (sort (vals (frequencies (map rank hand)))))))

(defn straight? [hand]
  nil)

(defn straight-flush? [hand]
  nil)

(defn value [hand]
  nil)
