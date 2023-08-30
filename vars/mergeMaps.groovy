import com.ops

def call(Map... maps){
    def mm =  new mapMerge(maps)
    return mm.merge(maps)
}
