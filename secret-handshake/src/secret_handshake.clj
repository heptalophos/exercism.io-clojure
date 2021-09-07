(ns secret-handshake)

(defn commands 
    [n] 
    (->> [(if (= 2r00001 (bit-and n 0x01)) 
              "wink")
          (if (= 2r00010 (bit-and n 0x02)) 
              "double blink")
          (if (= 2r00100 (bit-and n 0x04)) 
              "close your eyes")
          (if (= 2r01000 (bit-and n 0x08)) 
              "jump")]
         ((if (= 16 (bit-and n 0x10)) 
              reverse identity))
         (filter identity)))
